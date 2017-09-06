package io.chicken.ggs.dal.model;

import java.util.List;

public class AwardInfoDetail extends AwardInfo {
    List<AwardFile> awardFiles ;

    List<AwardQuota> awardQuotas ;

    List<AwardSchool> awardSchools;

    public List<AwardFile> getAwardFiles() {
        return awardFiles;
    }

    public void setAwardFiles(List<AwardFile> awardFiles) {
        this.awardFiles = awardFiles;
    }

    public List<AwardQuota> getAwardQuotas() {
        return awardQuotas;
    }

    public void setAwardQuotas(List<AwardQuota> awardQuotas) {
        this.awardQuotas = awardQuotas;
    }

    public List<AwardSchool> getAwardSchools() {
        return awardSchools;
    }

    public void setAwardSchools(List<AwardSchool> awardSchools) {
        this.awardSchools = awardSchools;
    }
}
