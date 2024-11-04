package fixdrive.system.controller;

import fixdrive.system.dto.FeedbackDto;
import fixdrive.system.model.Feedback;
import fixdrive.system.service.FeedbackService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Path("/feedback")
public class FeedbackController {
    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFeedbackById(@PathParam("id") Long id) {
        try {
            Feedback feedback = feedbackService.getFeedbackById(id);
            if (feedback != null) {
                return Response.ok(mapToDto(feedback)).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (SQLException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllFeedbacks() {
        try {
            List<Feedback> feedbacks = feedbackService.getAllFeedbacks();
            List<FeedbackDto> dtos = feedbacks.stream()
                    .map(this::mapToDto)
                    .collect(Collectors.toList());
            return Response.ok(dtos).build();
        } catch (SQLException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createFeedback(FeedbackDto feedbackDto) {
        try {
            Feedback feedback = new Feedback();
            feedback.setIdFeedback(feedbackDto.getId());
            feedback.setDsComentarioAvaliativo(feedbackDto.getDsComentarioAvaliativo());
            feedback.setNrPontuacaoAvaliativa(feedbackDto.getNrPontuacaoAvaliativa());
            feedback.setIdDiagnostico(feedbackDto.getIdDiagnostico());

            feedbackService.createFeedback(feedback);
            return Response.status(Response.Status.CREATED).entity(feedback).build();
        } catch (SQLException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateFeedback(@PathParam("id") Long id, FeedbackDto feedbackDto) {
        try {
            Feedback feedback = feedbackService.getFeedbackById(id);
            if (feedback != null) {
                feedback.setDsComentarioAvaliativo(feedbackDto.getDsComentarioAvaliativo());
                feedback.setNrPontuacaoAvaliativa(feedbackDto.getNrPontuacaoAvaliativa());
                feedback.setIdDiagnostico(feedbackDto.getIdDiagnostico());

                feedbackService.updateFeedback(feedback);
                return Response.ok(feedback).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (SQLException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteFeedback(@PathParam("id") Long id) {
        try {
            feedbackService.deleteFeedback(id);
            return Response.noContent().build();
        } catch (SQLException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    private FeedbackDto mapToDto(Feedback feedback) {
        FeedbackDto dto = new FeedbackDto();
        dto.setId(feedback.getIdFeedback());
        dto.setDsComentarioAvaliativo(feedback.getDsComentarioAvaliativo());
        dto.setNrPontuacaoAvaliativa(feedback.getNrPontuacaoAvaliativa());
        dto.setIdDiagnostico(feedback.getIdDiagnostico());
        return dto;
    }
}
