package model.portfolio.stock;

import org.javamoney.moneta.Money;

import java.time.LocalDate;

public class MarketValueEntry {
    private LocalDate date;
    private Money open;
    private Money high;
    private Money low;
    private Money close;
    private int volume;
}
