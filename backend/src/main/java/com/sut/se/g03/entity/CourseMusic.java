package com.sut.se.g03.entity;

import com.sut.se.g03.repository.CourseMusicRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
@Data

public class CourseMusic {
	@SequenceGenerator(name="courseMusic_seq",sequenceName="courseMusic_seq")
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="courseMusic_seq")
	@Id
    private Long id;
    @NotNull
    @Size(min = 3, max = 20)
    @Pattern(regexp = "\\w+|[ก-๙]+")
    private String Fname;

    @NotNull
    @Size(min = 3, max = 25)
    @Pattern(regexp = "\\w+|[ก-๙]+")
    private String Lname;
    
    @NotNull
    @Size(min = 1, max = 8)
    @Pattern(regexp = "\\w+|[ก-๙]+")
    private String nickname;

    @NotNull
    @Size(min = 10, max = 10)
    @Pattern(regexp = "[0]\\d+")
    private String telephone;

	@ManyToOne
	private Instrument instrument;

	@ManyToOne
    private Member member;
    
    @NotNull
    @ManyToOne
    private Classroom classroom;
    
    @ManyToOne
    private PaymentType paymentType;
    
    
    @ManyToOne
	private CourseTime courseTime;

	public CourseMusic(){}

   public CourseMusic(String Fname,String Lname,String nickname,String telephone,Member member,Classroom classroom,PaymentType paymentType,
                        Instrument instrument,CourseTime courseTime) {
        this.Fname = Fname;
        this.Lname = Lname;
        this.nickname = nickname;
        this.telephone = telephone;
        this.classroom = classroom;
        this.paymentType = paymentType;
        this.instrument = instrument;
        this.courseTime = courseTime;
        this.member = member;
        
    }
}

