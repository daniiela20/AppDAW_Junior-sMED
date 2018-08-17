package mx.utng.juniorsmed.appdaw;

/**
 * Created by Alexa on 12/08/2018.
 */

public class YouTubeVideos {
    private String Title;
    private String videoUrl;
    private String description;

    public YouTubeVideos() {
    }

    public YouTubeVideos(String title, String videoUrl, String description) {
        Title = title;
        this.videoUrl = videoUrl;
        this.description = description;
    }

    public String getVideoUrl() {
        return videoUrl;
    }
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
