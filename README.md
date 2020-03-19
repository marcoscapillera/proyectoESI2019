# proyectoESI2019

Propuesta
Una empresa de mantenimiento informático necesita se realice la base de datos para su
sistema central, el cual debe permitir mantener información referente a clientes, técnicos,
así como los servicios solicitados.
Debe permitir registrar datos de los técnicos C.I, Nombre completo (Nombre, Apellido
Materno, Apellido Paterno), Dirección (Calle, Numero, Localidad), Teléfonos y
Fecha_Ingreso.
Del cliente se necesita guardar C.I, Nombre completo (Nombre, Apellido Materno, Apellido
Paterno), Dirección (Calle, Numero, Localidad), Teléfonos, Tipo. El Tipo podría ser
“Empresa”, “Individuo”.
Cuando un cliente solicita servicios se necesita registrar: Presupuesto, Cant_horas,
Fecha_presentación, Fecha_inicio, Fecha_fin, Estado y Causa. Cada servicio solicitado por el
clientes es asignado a un técnico; éste puede atender varios.
De los servicios se quiere registrar el Número y Tipo, donde el Tipo puede ser entre otros
instalaciones, reparaciones, armado de PC, Cableado, etc. Se debe poder registrar los
insumos que se requieren (Número, Nombre, Tipo, Descripción, Cant_Stock, Precio), al
llevar a cabo un servicio. El Tipo (insumo) es Hardware o Software. Cuando se trata de Tipo
software, debemos poder diferenciar los gratuitos de los pagos.
Se debe tener en consideración que ya existen determinados paquetes de servicio estándar:
armado de pc, que ya tienen un cálculo de horas, insumos y costos predeterminado. Estos
paquetes, los cuales tienen un Nombre, se definen a partir de los insumos. Existen otros
servicios para los cuales el presupuesto se arma en base a las necesidades del momento.
También se requiere almacenar la procedencia de los insumos pudiendo almacenar la
siguiente información: Número de proveedor, Nombre, Teléfono, Direcciones (Calle,
Número, Localidad) y Dirección de e-mail. Cada insumo lo provee sólo un proveedor pero
éste puede entregar muchos; todos son suministrados por algún proveedor.
También se pide manejar la posibilidad de efectuar descuentos a determinados clientes ya
que se está pensando en instrumentar un sistema de clientes VIP. Un cliente puede tener
como máximo un perfil del cual se registra el Nombre del perfil y el Descuento a realizar.
En una entrevista con la empresa, se remarcó la necesidad de que la misma pudiera
obtener la
siguiente información:
● Cantidad de servicios realizados por determinado técnico.
● Horas dedicadas de cada técnico a los servicios.
● Insumos en stock. Procedencia de los mismos (distribuidor).
● Ganancias por determinado servicio.
● Periodos de mayor actividad.
● Insumos más usados.
● Causas por la cuales presupuestos no se llevaron a cabo
Se deben analizar e indicar las restricciones no estructurales que se desprenden de la letra.
