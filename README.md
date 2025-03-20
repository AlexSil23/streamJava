<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <h1>Java Streams</h1>
    <p>Java Streams son una secuencia de elementos que admiten operaciones secuenciales y paralelas.</p> 
    <h2>Características principales</h2>
    <ul>
        <li>Permiten el procesamiento declarativo de colecciones.</li> 
        <li>Facilitan la programación funcional en Java.</li>
        <li>Ofrecen operaciones intermedias y terminales.</li> 
        <li>Pueden ser secuenciales o paralelos.</li>
    </ul>
    <h2>Ejemplos de uso</h2>
    <p>Filtrar números pares de una lista:</p>
    <pre><code>
List&lt;Integer&gt; numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
List&lt;Integer&gt; pares = numeros.stream() 
                                  .filter(n -&gt; n % 2 == 0)
                                  .collect(Collectors.toList()); 
System.out.println(pares); // [2, 4, 6]
    </code></pre>
    <p>Mapear una lista de cadenas a su longitud:</p>
    <pre><code>
List&lt;String&gt; palabras = Arrays.asList("hola", "mundo", "java"); 
List&lt;Integer&gt; longitudes = palabras.stream()
                                      .map(String::length)
                                      .collect(Collectors.toList());
System.out.println(longitudes); // [4, 5, 4]
    </code></pre>
    <h2>Recursos adicionales</h2>
    <ul>
        <li><a href="https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html">Documentación oficial de Java Streams</a></li>
        <li><a href="https://www.oracle.com/technetwork/articles/java/ma14-java-se-8-streams-2177646.html">Artículo introductorio sobre Java Streams</a></li>
    </ul>
</body>
</html>
