package cesde.net.parqueadero.api.dtos;

import cesde.net.parqueadero.data.model.Car;
import cesde.net.parqueadero.data.model.Cell;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Data
public class ParkingLotDto {

    private Long id;
    private Car car;
    private Cell cell;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String startDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String finalDate;
    private Boolean active;


    public void setStartDate() throws ParseException {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //String now = format.format(date);

        this.startDate = format.format(date);
    }

    public void setFinaltDate() throws ParseException {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //String now = format.format(date);

        this.finalDate = format.format(date);
    }

    public String diff() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date data1 = format.parse(this.startDate);
        Date data2 = format.parse(this.finalDate);
        Long diff = data2.getTime() - data1.getTime();

        Long seconds = TimeUnit.MILLISECONDS.toSeconds(diff);
        Long minutes = TimeUnit.MILLISECONDS.toMinutes(diff);

        if (seconds%60 !=0)
            minutes += 1;

        float valor =  minutes * 100;

        return minutes + ":" + valor;
    }
}
