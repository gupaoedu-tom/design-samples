package com.gupaoedu.vip.pattern.prototype.demo;

import lombok.Data;

@Data
public class ExamPaper{

   private String examinationPaperId;//试卷主键
   private String leavTime;//剩余时间
   private String organizationId;//单位主键
   private String id;//考试主键
   private String examRoomId;//考场主键
   private String userId;//用户主键
   private String specialtyCode;//专业代码
   private String postionCode;//报考岗位
   private String gradeCode;//报考等级
   private String examStartTime;//考试开始时间
   private String examEndTime;//考试结束时间
   private String singleSelectionImpCount;//单选选题重要数量
   private String multiSelectionImpCount;//多选题重要数量
   private String judgementImpCount;//判断题重要数量
   private String examTime;//考试时长
   private String fullScore;//总分
   private String passScore;//及格分
   private String userName;//学员姓名
   private String score;//考试得分
   private String resut;//是否及格
   private String singleOkCount;//单选题答对数量
   private String multiOkCount;//多选题答对数量
   private String judgementOkCount;//判断题答对数量

   public ExamPaper copy(){
      ExamPaper examPaper = new ExamPaper();
      //剩余时间
      examPaper.setLeavTime(this.getLeavTime());
      //单位主键
      examPaper.setOrganizationId(this.getOrganizationId());
      //考试主键
      examPaper.setId(this.getId());
      //用户主键
      examPaper.setUserId(this.getUserId());
      //专业
      examPaper.setSpecialtyCode(this.getSpecialtyCode());
      //岗位
      examPaper.setPostionCode(this.getPostionCode());
      //等级
      examPaper.setGradeCode(this.getGradeCode());
      //考试开始时间
      examPaper.setExamStartTime(this.getExamStartTime());
      //考试结束时间
      examPaper.setExamEndTime(this.getExamEndTime());
      //单选题重要数量
      examPaper.setSingleSelectionImpCount(this.getSingleSelectionImpCount());
      //多选题重要数量
      examPaper.setMultiSelectionImpCount(this.getMultiSelectionImpCount());
      //判断题重要数量
      examPaper.setJudgementImpCount(this.getJudgementImpCount());
      //考试时间
      examPaper.setExamTime(this.getExamTime());
      //总分
      examPaper.setFullScore(this.getFullScore());
      //及格分
      examPaper.setPassScore(this.getPassScore());
      //学员姓名
      examPaper.setUserName(this.getUserName());
      //分数
      examPaper.setScore(this.getScore());

      //单选答对数量
      examPaper.setSingleOkCount(this.getSingleOkCount());
      //多选答对数量
      examPaper.setMultiOkCount(this.getMultiOkCount());
      //判断答对数量
      examPaper.setJudgementOkCount(this.getJudgementOkCount());

      return examPaper;
   }

   @Override
   public String toString() {
      return "ExamPaper{" +
              "examinationPaperId='" + examinationPaperId + '\'' +
              ", leavTime='" + leavTime + '\'' +
              ", organizationId='" + organizationId + '\'' +
              ", id='" + id + '\'' +
              ", examRoomId='" + examRoomId + '\'' +
              ", userId='" + userId + '\'' +
              ", specialtyCode='" + specialtyCode + '\'' +
              ", postionCode='" + postionCode + '\'' +
              ", gradeCode='" + gradeCode + '\'' +
              ", examStartTime='" + examStartTime + '\'' +
              ", examEndTime='" + examEndTime + '\'' +
              ", singleSelectionImpCount='" + singleSelectionImpCount + '\'' +
              ", multiSelectionImpCount='" + multiSelectionImpCount + '\'' +
              ", judgementImpCount='" + judgementImpCount + '\'' +
              ", examTime='" + examTime + '\'' +
              ", fullScore='" + fullScore + '\'' +
              ", passScore='" + passScore + '\'' +
              ", userName='" + userName + '\'' +
              ", score='" + score + '\'' +
              ", resut='" + resut + '\'' +
              ", singleOkCount='" + singleOkCount + '\'' +
              ", multiOkCount='" + multiOkCount + '\'' +
              ", judgementOkCount='" + judgementOkCount + '\'' +
              '}';
   }
}