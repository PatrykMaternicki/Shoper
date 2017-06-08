package rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import domain.Comment;
import domain.Product;

@Path ("/shop")
@Stateless
public class ShopResources {

	@PersistenceContext
	EntityManager em;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getAll (){
		return em.createNamedQuery("Product.all", Product.class).getResultList();
	}
	
	@POST
	@Path ("add/base")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addTestBase(List<Product> productList){
		productList.forEach((product)->em.persist(product));
		return Response.ok("ADDED").build();
	}
	
	@GET
	@Path("/get/product/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductOnId(@PathParam("id") int id){
		Product result = em.createNamedQuery("Product.id",Product.class).setParameter("id", id).getSingleResult();
		if (result == null ){
			return Response.status(400).build();
			
		}
		return Response.ok(result).build();
	}
	

	@PUT
	@Path("/update/product/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") int id, Product product){
		Product result = em.createNamedQuery("Product.id", Product.class).setParameter("id", id).getSingleResult();
		int resultId = result.getProductId();
		if (result == null ){
			return Response.status(400).build();
		}
		result = product;
		result.setProductId(resultId);
		em.persist(result);
		return Response.ok(result).build();
	}
	
	@GET
	@Path("/filter/prize/product/{fromPrize}/{toPrize}")
	@Produces (MediaType.APPLICATION_JSON)
	public List<Product> getProductOnPrize (@PathParam("fromPrize") double fromPrize, @PathParam("toPrize") double toPrize){
		List<Product> result = em.createNamedQuery("Product.filterPrize", Product.class).setParameter("fromPrize", fromPrize).setParameter("toPrize", toPrize).getResultList();
		if (result == null){
			return null;
		}
		return result;
	}
	
	@GET
	@Path("filter/name/product/{nameProduct}")
	@Produces (MediaType.APPLICATION_JSON)
	public Response getProductOnName (@PathParam("nameProduct") String nameProduct){
		Product result = em.createNamedQuery("Product.filterName" , Product.class).setParameter("nameProduct", nameProduct).getSingleResult();
		if (result == null){
			Response.ok("Empty Query").build();
		}
		return Response.ok(result).build();
		
	}
	
	@GET
	@Path("filter/category/product/{productCategory}")
	@Produces (MediaType.APPLICATION_JSON)
	public List<Product> getProductOnProductCategory (@PathParam("productCategory") String productCategory){
		List <Product> result = em.createNamedQuery("Product.filterCategory", Product.class).setParameter("category", productCategory).getResultList();
		if (result == null ){
			return null;
		}
	return result;
	}
	
	
	@POST
	@Path("add/comment/{personId}")
	@Consumes (MediaType.APPLICATION_JSON)
	public Response addCar(@PathParam("personId") int personId , Comment comment){
	  Product result = em.createNamedQuery("Product.id" , Product.class)
			  .setParameter("id", personId)
			  .getSingleResult();
	  if (result == null){
		  return Response.status(400).build();
	  }
	  result.getComments().add(comment);
	  comment.setProduct(result);
	  em.persist(comment);
	  return Response.ok(result).build();
	  
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response setProduct (Product product){
		em.persist(product);
		return Response.ok(product).build();
	}
	
	@PUT
	@Path("remove/comment/{commentId}/on/{productId}")
	@Consumes (MediaType.APPLICATION_JSON)
	public Response removeComment (@PathParam("commentId") int commentId, @PathParam("productId") int productId){
	Product result= em.createNamedQuery("Product.id" , Product.class).setParameter("id", productId).getSingleResult();
	if (result == null){
		return Response.status(400).build();
	}
	result.getComments().remove(commentId);
	em.persist(result);
	return Response.ok("Deleted").build();
	}
	
	@GET
	@Path("get/comment/on/{productId}")
	@Produces (MediaType.APPLICATION_JSON)
	public List<Comment> getListComment (@PathParam("productId") int productId){
	Product result = em.createNamedQuery("Product.id" , Product.class).setParameter("id", productId).getSingleResult();	
	if (result == null){
		return null;
	}
	return result.getComments();
	}
	
	
	
	


	
	
}
