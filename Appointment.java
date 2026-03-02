import java.io.Serializable;
import java.time.LocalDateTime;

public class Appointment implements Serializable {
    private String appointmentType;
    private LocalDateTime date;
    private String notes;

    public Appointment(String appointmentType, LocalDateTime date, String notes) {
        this.appointmentType = appointmentType;
        this.date = date;
        this.notes = notes;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getNotes() {
        return notes;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String toString() {
        return "Date: " + this.date +
                "\nAppointment Type: " + this.appointmentType +
                "\nNotes: " + this.notes;
    }
}