package cesde.net.parqueadero.api.dtos;

import cesde.net.parqueadero.data.model.Car;
import cesde.net.parqueadero.data.model.Cell;
import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Data
public class ParkingLotDto {

    private Long id;
    private Car car;
    private Cell cell;
    private Date startDate;
    private Date finalDate;
    private Boolean active = true;


    public void setStartDate() throws ParseException {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = format.format(date);

        this.startDate = format.parse(now);
    }

    public void setFinaltDate() throws ParseException {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = format.format(date);

        this.finalDate = format.parse(now);
    }

    public String diff() {
        Long diff = this.finalDate.getTime() - this.startDate.getTime();

        Long seconds = TimeUnit.MILLISECONDS.toSeconds(diff);
        Long minutes = TimeUnit.MILLISECONDS.toMinutes(diff);

        return minutes + ":" + seconds;
    }
}
