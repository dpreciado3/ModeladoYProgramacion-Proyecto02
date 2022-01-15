import java.util.Calendar;
import java.util.Date;

/**
 * Clase que controla la creación de nuevos proyectos
 */
public class ConstructorProyectos {
    
    /**
     * Crea un proyecto con las caracteristicas para poder ser desarrollado 
     * estando en el nivel Independiente
     * @return proyectoI1 el Proyecto para el nivel Independiente
     */
    public Proyecto construyeProyectoIdependiente1(){
        Proyecto proyectoI1 = new Proyecto();
        proyectoI1.agregaNombreProyecto("Clon de Mario Kart");
        proyectoI1.agregaNombreCliente("Maryo");
        proyectoI1.agregaPatronesRequeridos(new Strategy());
        proyectoI1.agregaDescripcion(" Maryo quiere empezar su vida como desarrollador de videojuegos, pero no sabe programar, y tampoco se le ocurre ninguna idea original para un juego. Por esto, te ha encargado “inspirarte” de una famosa franquicia de videojuegos familiares de carros, y con esto programar un videojuego titulado Maryo Cart. Maryo quiere que cada personaje tenga un comportamiento distinto en la pista (aceleración, velocidad, peso, etc.), así como poderes distintos.");
        proyectoI1.agregaLenguajesRequeridos(new CSharp());
        proyectoI1.agregaPaga(30000);
        proyectoI1.agregaFechaDeEntrega(calculaEntrega(100));
        return proyectoI1;
    }
    
    /**
     * Crea un proyecto con las caracteristicas para poder ser desarrollado 
     * estando en el nivel Pequeña Empresa
     * @return proyectoPE1 el Proyecto para el nivel Pequeña Empresa
     */
    public Proyecto construyeProyectoPequenaEmpresa1(){
        Proyecto proyectoPE1 = new Proyecto();
        proyectoPE1.agregaNombreProyecto("Base de datos de empleados");
        proyectoPE1.agregaNombreCliente("Jorge Godínez");
        proyectoPE1.agregaPatronesRequeridos(new Observer());
        proyectoPE1.agregaPatronesRequeridos(new Facade());
        proyectoPE1.agregaPatronesRequeridos(new IteratorPattern());
        proyectoPE1.agregaPatronesRequeridos(new Adapter());
        proyectoPE1.agregaDescripcion("el Lic. Godínez es dueño de una empresa de papel. A lo largo de su administración ha notado que sus asalariados son muy incumplidos con el horario de llegada. Recientemente ha contratado a empleados para una nueva sede, y desea que para esta sede se implemente un nuevo sistema de gestión de empleados. Quiere que se chequen los horarios de entrada y salida, y que esta información se utilice para otorgar bonos de puntualidad a sus empleados. Quiere que se utilice el sistema que ya tenía su oficina anterior sin que sufra cambios, pero que además además tenga esta nueva funcionalidad. Por último, quiere ver reportes del comportamiento de sus empleados en una aplicación móvil.");
        proyectoPE1.agregaLenguajesRequeridos(new PHP());
        proyectoPE1.agregaLenguajesRequeridos(new Java());
        proyectoPE1.agregaPaga(200000);
        proyectoPE1.agregaFechaDeEntrega(calculaEntrega(200));
        return proyectoPE1;
    }
    
    /**
     * Crea un proyecto con las caracteristicas para poder ser desarrollado 
     * estando en el nivel Coorporativo
     * @return proyectoC1 el Proyecto para el nivel Coorporativo
     */
    public Proyecto construyeProyectoCorporativo1(){
        Proyecto proyectoC1 = new Proyecto();
        proyectoC1.agregaNombreProyecto("Nueva criptomoneda del Banco de México");
        proyectoC1.agregaNombreCliente("Banco de México");
        proyectoC1.agregaPatronesRequeridos(new Proxy());
        proyectoC1.agregaPatronesRequeridos(new Singleton());
        proyectoC1.agregaPatronesRequeridos(new Facade());
        proyectoC1.agregaPatronesRequeridos(new Observer());
        proyectoC1.agregaPatronesRequeridos(new State());
        proyectoC1.agregaPatronesRequeridos(new Builder());
        proyectoC1.agregaDescripcion("siguiendo los pasos de Venezuela, el gobernador del Banco de México ha decidido iniciar un proyecto para crear una criptomoneda propia del gobierno mexicano y así impulsar las nuevas tecnologías, al mismo tiempo que disminuye el comercio informal. Por cuestiones de seguridad, quiere que esta nueva criptomoneda no aproveche ninguna implementación existente. Quiere que se maneje con cifrado de extremo a extremo, pero que el Banco de México tenga acceso a información general sobre su comportamiento y además control completo sobre su oferta. Quiere que cada usuario tenga acceso a una “cartera” única para hacer sus transacciones mediante aplicaciones para Android y iOS, y que esta aplicación tenga modo consumidor y modo empresarial. Por último, quiere que con los datos de uso de esta criptomoneda se decidan de forma automatizada e inteligente estrategias para que el mercado se mantenga estable.");
        proyectoC1.agregaLenguajesRequeridos(new C());
        proyectoC1.agregaLenguajesRequeridos(new Python());
        proyectoC1.agregaLenguajesRequeridos(new PHP());
        proyectoC1.agregaLenguajesRequeridos(new Kotlin());
        proyectoC1.agregaLenguajesRequeridos(new Swift());
        proyectoC1.agregaLenguajesRequeridos(new JavaScript());
        proyectoC1.agregaPaga(5000000);
        proyectoC1.agregaFechaDeEntrega(calculaEntrega(300));
        return proyectoC1;
    }
    
    /**
     * Calcula la fecha de entrega de un proyecto con base al número de días que
     * se le indique
     * @param dias el número de días que tarda en llevarse a cabo el proyecto
     * @return fecha de entrega del proyecto
     */
    private Date calculaEntrega(int dias){
        Date actual = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(actual);
        c.add(Calendar.DATE, dias);
        return c.getTime();
    }
}
