package akul.schedule.application;

import java.net.URI;
import java.nio.file.attribute.AclEntry.Builder;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import akul.schedule.application.dto.ScheduleModal;
import akul.schedule.application.service.scheduleService;

@Path("schedule")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ApplicationGetResource {

	scheduleService se=new scheduleService();
	@GET
	public List<ScheduleModal> getallschd(){
		return se.getallschdserv();
	}
	@GET
	@Path("/{taskname}")	
	public ScheduleModal getschd(@PathParam("taskname") String taskname,@Context UriInfo uriInfo){
		ScheduleModal sch = se.getschdserv(taskname);
		String uri=uriInfo.getBaseUriBuilder()
						.path(ApplicationGetResource.class)
						.path(sch.getTask())
						.toString();
		sch.setLinkUri(uri);
		return sch;
	}
	
	@POST
	public Response postschd(ScheduleModal ob, @Context UriInfo uriInfo){
		se.dbsaveserv(ob);
		String newTask=String.valueOf(ob.getTask());
		URI uri=uriInfo.getAbsolutePathBuilder().path(newTask).build();
		return Response.created(uri)//returning status codes and location headers
				.entity(ob)
				.build();
	}
	
	@PUT
	@Path("/{taskname}")
	public void putschd(@PathParam("taskname") String taskname,ScheduleModal ob){
		ob.setTask(taskname);
		se.updateschdserv(ob);
	}
	
	@DELETE
	@Path("/{taskname}")
	public void deleteschd(@PathParam("taskname") String taskname){
		se.deleteschdserv(taskname);
	}
	
	
	
}
