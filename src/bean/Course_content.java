package bean;

public class Course_content {
    private String content_id;
    private String course_id;
    private String content_topic_name;
    private String detail_content;
    private String video_link;
    private String references;

    public String getContent_id() {
        return content_id;
    }

    public void setContent_id(String content_id) {
        this.content_id = content_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getContent_topic_name() {
        return content_topic_name;
    }

    public void setContent_topic_name(String content_topic_name) {
        this.content_topic_name = content_topic_name;
    }

    public String getDetail_content() {
        return detail_content;
    }

    public void setDetail_content(String detail_content) {
        this.detail_content = detail_content;
    }

    public String getVideo_link() {
        return video_link;
    }

    public void setVideo_link(String video_link) {
        this.video_link = video_link;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }
}
