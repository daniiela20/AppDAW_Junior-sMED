package mx.utng.juniorsmed.appdaw;

/**
 * Created by Alexa on 05/07/2018.
 */

public class QuestionLibraryThree {
    private String mQuestions[] = {
            "_____ es un framework de desarrollo construido en lenguaje Ruby que permite construir aplicaciones web.",
            "En _____  comenzó el desarrollo el desarrollo de Ruby on Rails.",
            "Se liberó la primera versión al público en el año ____",
            "Es un lenguaje de programación que se usa para crear webs.",
            "Es un entorno de trabajo para Ruby.",
            "Son paquetes de código preparados por otras personas que se pueden usar en los proyectos.",
            "La separación de código en Ruby on Rails se conforma por:",
            "Abstrae los elementos implementando la lógica y estableciendo la relación entre ______",
            "Es lo que el usuario ve en el navegador (HTML), Contiene los gatillos para realizar acciones (enlaces y formularios)",
            "Realiza las peticiones del usuario y responde usando vistas o redirección a otra acción",



    };

    private String mChoices [] [] = {
            {"Notepad", "Ruby on Rails", "Pycharm"},
            {"1995", "1993", "1993"},
            {"1993", "1995", "2000"},
            {"Ruby", "Java", "Python"},
            {"Sublime", "Rails", "Pycharm"},
            {"Fragmentos", "Scripts", "Gemas"},
            {"Vista y Modelo", "Modelo, Vista y Controlador", "Controlador"},
            {"Modelo", "Controlador", "Vista"},
            {"Controlador", "Vista", "Modelo"},
            {"Vista", "Modelo", "Controlador"},

    };

    public String mCorrectAnswers [] = {"Ruby on Rails", "1993", "1995", "Ruby", "Rails", "Gemas", "Modelo, Vista y Controlador", "Modelo", "Vista", "Controlador",};


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
