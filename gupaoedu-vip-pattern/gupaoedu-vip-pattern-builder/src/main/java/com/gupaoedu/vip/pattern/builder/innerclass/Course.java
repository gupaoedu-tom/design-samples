package com.gupaoedu.vip.pattern.builder.innerclass;

import lombok.Data;

/**
 * Created by Tom.
 */
@Data
public class Course {
    private String name;
    private String ppt;
    private String video;
    private String note;

    private String homework;

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", ppt='" + ppt + '\'' +
                ", video='" + video + '\'' +
                ", note='" + note + '\'' +
                ", homework='" + homework + '\'' +
                '}';
    }

    public static class Builder {

        private Course course = new Course();

        public Builder addName(String name){
            course.setName(name);
            return this;
        }

        public Builder addPpt(String ppt){
            course.setPpt(ppt);
            return this;
        }

        public Builder addVideo(String video){
            course.setVideo(video);
            return this;
        }

        public Builder addNote(String note){
            course.setNote(note);
            return this;
        }

        public Builder addHomework(String homework){
            course.setHomework(homework);
            return this;
        }

        public Course builder(){
            return course;
        }

    }
}
