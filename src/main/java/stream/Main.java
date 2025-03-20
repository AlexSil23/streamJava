package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main{

	public static void main(String[] args) {
		
		List<Curso> cursos = new ArrayList<>();
		cursos.add(new Curso("Cursos profesional de Java", 6.5f, 50, 200));
		cursos.add(new Curso("Cursos profesional de Python", 8.5f, 60, 800));
		cursos.add(new Curso("Cursos profesional de DB", 4.5f, 70, 700));
		cursos.add(new Curso("Cursos profesional de Android", 7.5f, 10, 400));
		cursos.add(new Curso("Cursos profesional de Escritura", 1.5f, 10, 300));

		// Obtener la cantidad de cursos con una duración mayor a 5 horas.
		long cantidadDuracionMas = cursos.stream().filter(hora -> hora.getDuracion() > 5).count();
		System.out.println("Cantidad de cursos con una duración mayor a 5 horas: " + cantidadDuracionMas);

		// Obtener la cantidad de cursos con una duración menor a 2 horas.
		long cantidadDuracionMenos = cursos.stream().filter(hora -> hora.getDuracion() < 2).count();
		System.out.println("Cantidad de cursos con una duración menor a 2 horas: " + cantidadDuracionMenos);

		// Listar el título de todos aquellos cursos con una cantidad de vídeos mayor a
		// 50.
		System.out.println("Los cursos con una cantidad de vídeos mayor a 50: ");

		List<String> titulosMayores = cursos.stream().filter(video -> video.getVideos() > 50)
				.map(Curso::getTitulo)
				.collect(Collectors.toList());
		titulosMayores.forEach(titulo -> System.out.println(titulo));

		// Mostrar en consola el título de los 3 cursos con mayor duración.
		System.out.println("Los 3 cursos con mayor duración: "); 

		cursos.stream()
			.sorted(Comparator.comparingDouble(Curso::getDuracion).reversed())// Ordenar por duración descendente
			.limit(3)// Tomar los primeros 3 cursos
			.map(Curso::getTitulo)// Obtener solo los títulos
			.forEach(titulo -> System.out.println(titulo));

		// Mostrar en consola la duración total de todos los cursos.
		double total = cursos.stream().mapToDouble(Curso::getDuracion).sum();
		System.out.println("Duración total de todos los cursos " + total);
		
		// Mostrar en consola todos aquellos libros que superen el promedio en cuanto a duración se refiere.
		double promedio = total /cursos.stream().count();
		System.out.println("Libros que superen el promedio en cuanto a duración se refiere "+ promedio);
		cursos.stream()
			.filter(duracion -> duracion.getDuracion()>promedio)
			.map(Curso::getTitulo)
			.forEach(titulo -> System.out.println(titulo));
		
		//Mostrar en consola la duración de todos aquellos cursos que tengan una cantidad de alumnos inscritos menor a 500.
		System.out.println("Duración de todos aquellos cursos que tengan una cantidad de alumnos inscritos menor a 500");
		cursos.stream()
			.filter(alumnos->alumnos.getAlumnos()>500)
			.map(Curso::getDuracion)
			.forEach(duracion->System.out.println(duracion));
		
		//Obtener el curso con mayor duración
		System.out.println("El curso con mayor duración es:"); 
		cursos.stream()
			.sorted(Comparator.comparingDouble(Curso::getDuracion).reversed())// Ordenar por duración descendente
			.limit(1)
			.map(Curso::getTitulo)
			.forEach(titulo -> System.out.println(titulo));
			
		//Crear una lista de Strings con todos los titulos de los cursos.
		System.out.println("Lista con todos los titulos de los cursos");
		List<String> listaTitulos = cursos.stream()
				.map(Curso::getTitulo)
				.toList();		
		listaTitulos.forEach(titulos->System.out.println(titulos));		
	}
}
