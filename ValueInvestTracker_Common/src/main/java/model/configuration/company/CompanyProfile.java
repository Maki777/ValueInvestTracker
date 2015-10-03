package model.configuration.company;

import model.configuration.company.prospects.CombinedProspect;
import model.configuration.company.prospects.CompanyProspect;

import java.util.Map;

public class CompanyProfile {
    private Map<CompanyProspect,Double> companyProspectProbabilities;
    private Map<CompanyProspect,Double> adjustedCompanyProspectProbabilities;
    private Map<CombinedProspect,Double> conditionalProspectProbabilities;
    private double pessimisticCaseFactor;
    private double realisticCaseFactor;
    private double optimisticCaseFactor;
    private double bullFactor;
    private double averageFactor;
    private double bearFactor;
    private double marketDependency;

    public double getProbability(CombinedProspect combinedProspect){
        Double companyProspectProbability = getAdjustedProbability(combinedProspect.getCompanyProspect());
        Double marketBasedOnCompanyProspectProbability = conditionalProspectProbabilities.getOrDefault(combinedProspect,0.0);
        return companyProspectProbability*marketBasedOnCompanyProspectProbability;
    }

    private double getOriginalProbability(CompanyProspect companyProspect){
        return companyProspectProbabilities.getOrDefault(companyProspect,0.0);
    }

    private double getAdjustedProbability(CompanyProspect companyProspect){
        return adjustedCompanyProspectProbabilities.getOrDefault(companyProspect,0.0);
    }

    public void adjustCompanyProspectProbabilities(double marketPrediction){
        double optimisticProbability=getOriginalProbability(CompanyProspect.OPTIMISTIC);
        double realisticProbability=getOriginalProbability(CompanyProspect.REALISTIC);
        double pessimisticProbability=getOriginalProbability(CompanyProspect.PESSIMISTIC);
        if(marketPrediction>0){
            adjustedCompanyProspectProbabilities.put(CompanyProspect.OPTIMISTIC,optimisticProbability+(realisticProbability+pessimisticProbability)*marketPrediction*marketDependency);
            adjustedCompanyProspectProbabilities.put(CompanyProspect.REALISTIC,realisticProbability*(1-marketPrediction*marketDependency));
            adjustedCompanyProspectProbabilities.put(CompanyProspect.PESSIMISTIC,pessimisticProbability*(1-marketPrediction*marketDependency));
        }
        else{
            adjustedCompanyProspectProbabilities.put(CompanyProspect.PESSIMISTIC,pessimisticProbability+(realisticProbability+optimisticProbability)*marketPrediction*marketDependency);
            adjustedCompanyProspectProbabilities.put(CompanyProspect.REALISTIC,realisticProbability*(1-marketPrediction*marketDependency));
            adjustedCompanyProspectProbabilities.put(CompanyProspect.OPTIMISTIC,optimisticProbability*(1-marketPrediction*marketDependency));
        }
    }

}
