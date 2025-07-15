package com.geneza.lms.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;

@Entity
@Table(name = "session_attendance")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "GenezaRest/com/geneza/lms/domain", name = "sessionAttendance")
public class SessionAttendance implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement
    private Integer id;

    private boolean attendance;

    @ManyToOne
    @JoinColumn(name = "sessionId", nullable = false)
    private Session session;

    @ManyToOne
    @JoinColumn(name = "enrollmentId", nullable = false)
    private Enrollment enrollment;

    // Getters and setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public boolean isAttendance() { return attendance; }
    public void setAttendance(boolean attendance) { this.attendance = attendance; }

    public Session getSession() { return session; }
    public void setSession(Session session) { this.session = session; }

    public Enrollment getEnrollment() { return enrollment; }
    public void setEnrollment(Enrollment enrollment) { this.enrollment = enrollment; }
}
