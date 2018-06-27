package com.scal.oa.Contorller;

import com.scal.oa.domain.OaDocStep;
import com.scal.oa.repository.OaDocStepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OaDocSetpController {
    @Autowired
    private OaDocStepRepository oaDocSetpRepository;

    @RequestMapping(value="all")
    public List<OaDocStep> StepAll()
    {
        return oaDocSetpRepository.findAll();
    }
}
