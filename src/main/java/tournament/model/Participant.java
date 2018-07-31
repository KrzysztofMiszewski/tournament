package tournament.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Participant {

        @Id
        @GeneratedValue
        private Long id;

        @Column(unique = true)
        private String mail;

        private String password;

        public Long getId() {
            return id;
        }

        public String getMail() {
            return mail;
        }

        public void setMail(String mail) {
            this.mail = mail;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }