package de.schroeder.mapstruct.person.control;

import de.schroeder.mapstruct.person.boundary.PersonResource;
import de.schroeder.mapstruct.person.entity.PersonEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

/**
 * Mapper Interface which generates Mappings by Annotationprocessing by MapStructs
 *
 * Important:
 * To avoid compilation Errors when using IntelliJ to assemble the application, you have to delegate build/run actions
 * to gradle (settings-> Build/... -> Gradle -> Runner)
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PersonMapper {

    List<PersonResource> mapToResources(List<PersonEntity> entity);

    @Mappings({
        @Mapping(target = "fullname", expression = "java(entity.getName() + \" \" + entity.getSurname())"),
        @Mapping(source = "birthday", target = "birthday")
    })
    PersonResource mapToResource(PersonEntity entity);
}
