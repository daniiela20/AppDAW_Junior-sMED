package mx.utng.juniorsmed.appdaw;

/**
 * Created by Alexa on 05/07/2018.
 */

public class QuestionLibraryOne {
    private String mQuestions [] = {
            "Son aplicaciones web creadas con la tecnología Flash.",
            "Aplicación que muestra muy poca información no generan nuevos contenidos.",
            "Utilizan bases de datos para cargar la información y los contenidos.",
            "Se basa en el uso de certificados digitales para asegurar la perfecta identificación.",
            "Nuevo protocolo que permitiera transacciones seguras por Internet.",
            "Son plataformas de Internet personal, pero también existen corporativas, empresariales y temáticas..",
            "Entre los años 2001 y 2002 aparecen por primera vez estos sitios.",
            "Ocurre cuando a nuestro sistema entra información no confiable por formularios.",
            "El atacante engaña a la víctima a enviar solicitudes HTTP.",
            "Se presenta cuando es posible suplantar la identidad del usuario."


    };


    private String mChoices [][] = {
            {"Aplicación web estática", "Aplicación web animada", "E-commerce"},
            {"Aplicación web animada ", "E-commerce", "Aplicación web estática"},
            {"E-commerce", "Aplicación web estática", "Aplicación web dinámica"},
            {"Secure Socket Layer ", "Protocolo SET", "S-HTTP "},
            {"Transport Layer Security (TLS)", "S-HTTP ", "Secure Socket Layer "},
            {"Periódico Electrónico ", "Podcast", "Blogs"},
            {"Cine Digital ", "Podcast", "Redes sociales"},
            {"Inyección", "Configuración errónea de seguridad", "Fallas al restringir acceso URL"},
            {"Almacenamiento inseguro", "Solicitudes falsificadas en sitios cruzados", "Autenticación rota"},
            {"Configuración errónea de seguridad", "Autenticación rota", "Inyección"}
    };



    private String mCorrectAnswers[] = {"Aplicación web animada", "Aplicación web estática", "Aplicación web dinámica","Protocolo SET",
            "Transport Layer Security (TLS)","Blogs","Redes sociales","Inyección","Solicitudes falsificadas en sitios cruzados","Autenticación rota"};




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
