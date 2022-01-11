import java.util.Date;
import java.text.SimpleDateFormat;

public class ControladorStatus implements ObservadorPartida {
    private ModeloPartida modeloPartida;
    private VistaStatus vistaStatus;
    private Date fechaActual;

    public ControladorStatus(ModeloPartida modeloPartida, VistaStatus vistaStatus) {
        this.modeloPartida = modeloPartida;
        this.vistaStatus = vistaStatus;
    }
    
    @Override
    public void actualizaFecha(Date fecha) {
        fechaActual = fecha;
        vistaStatus.setFecha(fechaActual.toString());
    }
    
}
