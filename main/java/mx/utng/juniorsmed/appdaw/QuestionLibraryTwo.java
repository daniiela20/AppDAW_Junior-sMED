package mx.utng.juniorsmed.appdaw;

/**
 * Created by Alexa on 05/07/2018.
 */

public class QuestionLibraryTwo {

    private String mQuestions[] = {
            "Se encarga de organizar, etiquetar y estructurar los diferentes flujos informativos creando un mapa que guíe al visitante del sitio.",
            "Accede a la información que necesita de forma rápida y fácil.",
            "Transmite el deseo de recuperar la inversión, demostrando el valor del servicio.",
            "La _____ es el estudio y mejora de la forma en que los usuarios navegan, buscan información o interactúan con un servicio web.",
            "Los _____ son soluciones para problemas típicos y recurrentes que nos podemos encontrar a la hora de desarrollar una aplicación.",
            "La _____ Aplica un conjunto de técnicas para identificar y solucionar estos problemas.",
            "Son utilizados para instanciar objetos, y así separar la implementación del cliente de la de los objetos que se utilizan.",
            "Se utilizan a la hora de definir como las clases y objetos interaccionan entre ellos.",
            "Son utilizados para crear clases u objetos que incluidos dentro de estructuras más complejas.",
            "La _____ se refiere precisamente a las conexiones y relaciones entre páginas.",



    };

    private String mChoices [] [] = {
            {"Arquitectura de la información", "Fundamentos de Arquitectura", "Fundamentos de la información"},
            {"Perspectivas de usuario", "Perspectivas del Propietario", "Usabilidad"},
            {"Usabilidad", "Perspectivas de usuario", "Perspectivas del Propietario"},
            {"Perspectivas del Propietario", "Usabilidad", "Perspectivas de usuario"},
            {"Usabilidad", "Patrones de diseño", "Perspectivas del Propietario"},
            {"Usabilidad", "Patrones de diseño", "Patrones creacionales"},
            {"Patrones creacionales", "Patrones de comportamiento", "Patrones de estructuras"},
            {"Patrones de comportamiento", "Patrones creacionales", "Patrones de estructuras"},
            {"Patrones de comportamiento", "Patrones estructurales", "Patrones creacionales"},
            {"Estructura del sitio", "Usabilidad", "Patrones"},

    };

    public String mCorrectAnswers [] = {"Arquitectura de la información", "Perspectivas de usuario", "Perspectivas del Propietario", "Usabilidad", "Patrones de diseño", "Usabilidad", "Patrones creacionales", "Patrones de comportamiento", "Patrones estructurales", "Estructura del sitio",};


    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }


    public String getChoiceOne(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }


    public String getChoiceTwo(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoiceThree(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }

}

