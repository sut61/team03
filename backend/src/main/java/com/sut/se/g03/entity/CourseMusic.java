package com.sut.se.g03.entity;

import com.sut.se.g03.repository.CourseMusicRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotBlank;
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
    @Pattern(regexp = "^(([ก-ู]|[เ-์]){3,20})$")
    @NotBlank
    private String Fname;

    @NotNull
    @Size(min = 3, max = 25)
    @Pattern(regexp = "^(([ก-ู]|[เ-์]){3,25})$")
    @NotBlank
    private String Lname;
    
    @NotNull
    @Size(min = 3, max = 16)
    @Pattern(regexp = "^(([ก-ู]|[เ-์]){3,16})$")
    @NotBlank
    private String nickname;

    @NotNull
    @Size(min = 10, max = 10)
    @Pattern(regexp = "[0]\\d+")
    @NotBlank
    private String telephone;

    @NotNull
	@ManyToOne
	private Instrument instrument;

    @NotNull
    @ManyToOne
    private Member member;
    
    @NotNull
    @ManyToOne
    private Classroom classroom;
    
    @NotNull
    @ManyToOne
    private PaymentType paymentType;
    
    @NotNull
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

