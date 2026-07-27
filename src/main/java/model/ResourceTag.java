package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="ResourceTag")
@Data
public class ResourceTag {
	@Id
	private Long tagId;
	private String tagValue;
	

}
