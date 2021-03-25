package rev.web.doc.viewer.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rev.web.doc.viewer.domain.entity.RequestParameter;
import rev.web.doc.viewer.domain.repository.RequestParameterRepository;

import java.util.List;

@Service
public class RequestParameterService {
    private final RequestParameterRepository requestParameterRepository;

    @Autowired
    public RequestParameterService(RequestParameterRepository requestParameterRepository){
        this.requestParameterRepository = requestParameterRepository;
    }

    List<RequestParameter> getRequestParametersByPageId(Long id){
        return requestParameterRepository.findByPageId(id);
    }
}
