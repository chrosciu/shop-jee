package pl.training.jakarta;

import java.time.format.DateTimeFormatter;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("time")
public class TimeService {

    @EJB
    private TimeProvider timeProvider;

    @GET
    public String time() {
        return timeProvider.getDataTime().format(DateTimeFormatter.ISO_LOCAL_TIME);
    }

}
