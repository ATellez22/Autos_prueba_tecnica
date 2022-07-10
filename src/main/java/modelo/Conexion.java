package modelo;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
	private static BasicDataSource dataSource=null;
	
	private static DataSource getDataSource() {
		
		if (dataSource==null) {
			
			dataSource= new BasicDataSource();
			dataSource.setDriverClassName("org.postgresql.Driver");
			dataSource.setUsername("postgres");
			dataSource.setPassword("admin");
			dataSource.setUrl("jdbc:postgresql://192.168.2.174:5432/autos");
			dataSource.setInitialSize(20); //El n�mero inicial de conexiones que se crean cuando se inicia el grupo.
			dataSource.setMaxTotal(-10); //El n�mero m�ximo de conexiones activas que se pueden asignar desde este grupo al mismo tiempo,
											//o negativo para ning�n l�mite.
			dataSource.setMaxWaitMillis(-1);// El n�mero m�ximo de milisegundos que esperar� el grupo (cuando no hay conexiones disponibles)
											//para que se devuelva una conexi�n antes de lanzar una excepci�n, o -1 para esperar indefinidamente.
			dataSource.setMaxConnLifetimeMillis(5000); //La vida m�xima en milisegundos de una conexi�n. Una vez superado este tiempo,
													//la conexi�n fallar� en la siguiente prueba de activaci�n, pasivaci�n o validaci�n.
													//Un valor de cero o menos significa que la conexi�n tiene una vida �til infinita.
			dataSource.setMaxIdle(30); //La cantidad m�xima de conexiones que pueden permanecer inactivas en el grupo, sin que se liberen
										//otras adicionales, o negativas sin l�mite.
			dataSource.setMaxTotal(-1);	//El n�mero m�ximo de conexiones activas que se pueden asignar desde este grupo al mismo tiempo,
										//o negativo para ning�n l�mite.		
			dataSource.setRemoveAbandonedTimeout(300); //Tiempo de espera en segundos antes de que se pueda eliminar una conexi�n abandonada.
			
		}
		
		return dataSource;
	}
	
	public static Connection getConnection() throws SQLException {
		return getDataSource().getConnection();
	}
}

/**

El tama�o del grupo inicial de la propiedad especifica el n�mero de conexiones disponibles que se crean cuando la agrupaci�n de conexiones es inicialmente creada
 o se reinicializa. Esta propiedad se utiliza normalmente para reducir el tiempo de arranque necesario para el purgado del pool a su tama�o �ptimo.

Un valor de cero indica que no hay conexiones creadas previamente. El valor predeterminado es cero. El siguiente ejemplo muestra la configuraci�n
 de un tama�o de grupo inicial:

pds.setInitialPoolSize(5);

Ajuste el tama�o m�nimo del pool
El tama�o m�nimo del pool especifica la cantidad m�nima de las conexiones disponibles y prestadas que un grupo mantiene. 
Un grupo de conexiones siempre trata de volver al tama�o m�nimo especificado a menos que la cantidad m�nima a�n no se ha alcanzado. Por ejemplo, si el l�mite m�nimo
 se establece en diez y s�lo dos conexiones se han creado y prestado, entonces el n�mero de conexiones que mantiene el pool permanece en dos.

Esta propiedad permite que el n�mero de conexiones del pool disminuya a medida que disminuye la demanda. Al mismo tiempo, la propiedad se asegura de que los recursos 
del sistema no se desperdician en el mantenimiento de las conexiones que son innecesarias. El valor predeterminado es cero. El siguiente ejemplo muestra la configuraci�n
 de un pool de tama�o m�nimo:

pds.setMinPoolSize(2);

Establecer el tama�o m�ximo de Pool
El tama�o m�ximo especifica el n�mero m�ximo de las conexiones que mantiene un pool. Si se toman prestadas el n�mero m�ximo de conexiones, las conexiones no estar�n 
disponibles hasta que una conexi�n se devuelve al pool.

Esta propiedad permite que el n�mero de conexiones en el pool aumente a medida que aumenta la demanda. Al mismo tiempo, la propiedad asegura que el pool no crezca hasta 
el punto de agotar los recursos de un sistema, que en �ltima instancia, afecta al rendimiento de una aplicaci�n y disponibilidad.

Un valor de cero indica que no hay conexiones gestionada por el pool. Un intento de obtener un resultado de conexi�n en esta situaci�n, es una excepci�n. 
El siguiente ejemplo muestra la configuraci�n del tama�o m�ximo del grupo:

pds.setMaxPoolSize(100);

**/