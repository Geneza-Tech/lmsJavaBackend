package com.geneza.lms.dto;

public class ParticipantDTO {
    private Long id;
    private PersonDto person;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public PersonDto getPerson() { return person; }
    public void setPerson(PersonDto person) { this.person = person; }

    public static class PersonDto {
        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private String role;

        // Add other fields if needed

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getFirstName() { return firstName; }
        public void setFirstName(String firstName) { this.firstName = firstName; }

        public String getLastName() { return lastName; }
        public void setLastName(String lastName) { this.lastName = lastName; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getPhone() { return phone; }
        public void setPhone(String phone) { this.phone = phone; }

        public String getRole() { return role; }
        public void setRole(String role) { this.role = role; }
    }
}

