package akul.schedule.application.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import akul.schedule.application.dto.ErrorMessage;
@Provider
public class DataNotFoundMapper implements ExceptionMapper<DataNotFound>{

	@Override
	public Response toResponse(DataNotFound ex) {
		ErrorMessage er=new ErrorMessage(ex.getMessage(), 404);
		return Response.status(Status.NOT_FOUND)
				.entity(er)
				.build();				
	}

}
