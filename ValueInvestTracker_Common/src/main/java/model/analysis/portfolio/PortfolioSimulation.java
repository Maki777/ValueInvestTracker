package model.analysis.portfolio;

import model.configuration.company.prospects.CombinedProspect;
import model.portfolio.InvestmentItem;
import model.portfolio.Portfolio;

import java.util.Map;

public class PortfolioSimulation {
    private Portfolio portfolio;
    private Map<InvestmentItem,CombinedProspect> simulationProspects;
}
