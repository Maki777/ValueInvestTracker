package model.analysis.portfolio;

import model.analysis.portfolio.PortfolioRiskProfile;
import model.portfolio.Portfolio;
import org.javamoney.moneta.Money;

public class PortfolioEvaluation {
    private Portfolio portfolio;
    private Money worstCaseValue;
    private Money expectedValue;
    private Money bestCaseValue;
    private Money currentRealValue;
    private PortfolioRiskProfile portfolioRiskProfile;

}
