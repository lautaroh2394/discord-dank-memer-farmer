# discord-dank-memer-farmer
Sencillo programa que automatiza el farmeo de coins para el bot "Dank Memer"

Como usar: doble click a run.bat
Quizá abrir como administrador si falla.


El programa abrirá una ventana en chrome donde hay que loguearse y elegir el canal donde tirar los comandos. Tiene que verse el textbox donde uno escribiría. Luego, enter una o dos veces en la consola del bat y listo.


Recordar escribir en el data.json para la key driverpath el path al chromedriver.exe (no funcionará con el geckodriver).

En el mismo data.json para la key commands definir una lista de comandos. Estos se ejecutarán cada 61 segundos.

TODO's:

-Hacer más customizables los comandos: Poder definir para cada uno el intervalo entre ejecuciones

-Intentar que selenium corra headless
