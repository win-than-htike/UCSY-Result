package xyz.winthan.ucsyresult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Win Than on 11/4/2016.
 */
public class ExamResult {

    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("roll_no")
    private String rollNo;
    @SerializedName("year")
    private String year;
    @SerializedName("major")
    private String major;
    @SerializedName("subject")
    private String subject;
    @SerializedName("credit")
    private String credit;
    @SerializedName("external")
    private String external;

    public ExamResult(Integer id, String name, String rollNo, String year, String major, String subject, String credit, String external) {
        this.id = id;
        this.name = name;
        this.rollNo = rollNo;
        this.year = year;
        this.major = major;
        this.subject = subject;
        this.credit = credit;
        this.external = external;
    }

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The rollNo
     */
    public String getRollNo() {
        return rollNo;
    }

    /**
     *
     * @param rollNo
     * The roll_no
     */
    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    /**
     *
     * @return
     * The year
     */
    public String getYear() {
        return year;
    }

    /**
     *
     * @param year
     * The year
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     *
     * @return
     * The major
     */
    public String getMajor() {
        return major;
    }

    /**
     *
     * @param major
     * The major
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     *
     * @return
     * The subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     *
     * @param subject
     * The subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     *
     * @return
     * The credit
     */
    public String getCredit() {
        return credit;
    }

    /**
     *
     * @param credit
     * The credit
     */
    public void setCredit(String credit) {
        this.credit = credit;
    }

    /**
     *
     * @return
     * The external
     */
    public String getExternal() {
        return external;
    }

    /**
     *
     * @param external
     * The external
     */
    public void setExternal(String external) {
        this.external = external;
    }


}
