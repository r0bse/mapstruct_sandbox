package de.schroeder.mapstruct.marvel.control;

import de.schroeder.mapstruct.marvel.boundary.PersonResource;
import de.schroeder.mapstruct.marvel.entity.PersonEntity;
import java.util.List;
import org.mapstruct.Mapper;
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

//    @Mappings ({
//    })
    PersonResource mapToResource(PersonEntity entity);
}
