package com.scal.oa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OA_DOC_Step")
public class OaDocStep {
    @Id
    @Column(name="step")
    private String step;
    @Column(name="step_CHN")
    private String stepCHN;
    @Column(name="Active_Flag")
    private String activeFlag;

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getStepCHN() {
        return stepCHN;
    }

    public void setStepCHN(String stepCHN) {
        this.stepCHN = stepCHN;
    }

    public String getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(String activeFlag) {
        this.activeFlag = activeFlag;
    }
}
