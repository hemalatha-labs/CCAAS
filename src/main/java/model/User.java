package model;

//import org.springframework.data.auditing.CurrentDateTimeProvider;
//import java.time.LocalDateTime;
//import Enumuration.Role;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import lombok.Data;


//@Entity
//@Data
//@Table(name = "user")
//public class User {

	//@Id
	//private Long userId;
	
	//private String name;
	//private String email;
	//private Role role;
	//private String organization;
	//private LocalDateTime timeStamp;
	//private CurrentDateTimeProvider timeStap;
//}

import Enumuration.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    private Long userId;

    private String name;

    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    private Boolean status;

}

