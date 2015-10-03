package model.configuration.expenses;

import org.javamoney.moneta.Money;

public class FeeProfile {
    private Money minimumBaseFee;
    private double baseFeePercentage;
    private Money additionalMinimumBaseFees;
    private double additionalFeePercentage;
}
