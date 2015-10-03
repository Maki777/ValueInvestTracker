package model.analysis.investmentitem;

import model.analysis.investmentitem.action.InvestmentAction;
import model.analysis.investmentitem.action.InvestmentActionHistory;
import model.configuration.analysis.AnalysisProfile;
import model.configuration.company.CompanyProfile;
import model.configuration.company.MarketProfile;
import model.configuration.expenses.FeeProfile;
import model.configuration.expenses.TaxProfile;
import model.portfolio.InvestmentItem;
import org.javamoney.moneta.Money;

public class InvestmentItemEvaluation {
    private InvestmentItem investmentItem;
    private InvestmentActionHistory investmentActionHistory;
    private InvestmentAction expectedInvestmentAction;
    private CompanyProfile companyProfile;
    private MarketProfile marketProfile;
    private FeeProfile feeProfile;
    private TaxProfile taxProfile;
    private AnalysisProfile analysisProfile;

    private Money adjustedMarketPrice;
    private Money worstCaseValue;
    private Money expectedValue;
    private Money bestCaseValue;
    private Money currentRealValue;

}
