package com.calculo_folha_pagamento_lab1_grupo5.backend.model;

public enum EGrauInsalubridade {
    NENHUM(0.0),
    MINIMA(0.10),
    MEDIA(0.20),
    MAXIMA(0.40);

    private final double percentual;

    EGrauInsalubridade(double percentual) {
        this.percentual = percentual;
    }

    public double getPercentual() { return percentual; }
}