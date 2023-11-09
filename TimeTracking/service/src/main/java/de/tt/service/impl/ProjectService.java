package de.tt.service.impl;
import java.util.List;
import de.tt.persistence.entity.ProjectEntity;
import de.tt.persistence.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 
 * Project Service class
 *
 */
@Service
public class ProjectService implements ServiceInterface<ProjectEntity, ProjectRepository> {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public ProjectRepository getRepository() {
        return projectRepository;
    }

    public List<ProjectEntity> findAllWithoutTimeTrack() {
        return projectRepository.findAllWithoutTimeTrack();
    }

    public List<ProjectEntity> findAllWithoutOtherTimeTrack(Long id) {
        return projectRepository.findAllWithoutOtherTimeTrack(id);
    }

}
