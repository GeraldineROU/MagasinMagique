package com.magasin;

class Magasin {
    Item[] items;

    public Magasin(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            if (isComte(i)) {
                if (isPassed(i) && isQualityBelow50(i)) {
                    qualityPlusOne(items[i]);
                    sellInDecreasedBy1(items[i]);
                } else if (isQualityBelow50(i)) {
                    qualityPlusOne(items[i]);
                    sellInDecreasedBy1(items[i]);
                } else if (!isQualityBelow50(i)) {
                    sellInDecreasedBy1(items[i]);
                }
            }

            if (isStandardItem(i)) {
                if (items[i].quality > 0 && !isPassed(i)) {
                    qualityMinusOne(items[i]);
                    sellInDecreasedBy1(items[i]);
                } else if (items[i].quality < 1 && !isPassed(i)) {
                    sellInDecreasedBy1(items[i]);
                } else if (isPassed(i) && items[i].quality > 0){
                    qualityMinusTwo(items[i]);
                    sellInDecreasedBy1(items[i]);
                } else if (items[i].quality < 1 && isPassed(i)) {
                    sellInDecreasedBy1(items[i]);
                }
            }

            if (isPassVipConcert(i)) {
                if (!isQualityBelow50(i)) {
                    sellInDecreasedBy1(items[i]);
                } else if (items[i].sellIn > 10 && isQualityBelow50(i)) {
                   qualityPlusOne(items[i]);
                   sellInDecreasedBy1(items[i]);
                } else if (isVipPassQualityToBeIncreasedBy2(i) && isQualityBelow50(i)) {
                   qualityPlus2(items[i]);
                   sellInDecreasedBy1(items[i]);
               } else if (isVipPassQualityToBeIncreasedBy3(i) && isQualityBelow50(i)) {
                   qualityPlus3(items[i]);
                   sellInDecreasedBy1(items[i]);
               } else if (isPassed(i)) {
                   items[i].quality = 0;
                   sellInDecreasedBy1(items[i]);
               }
            }

        }
    }


    private void sellInDecreasedBy1(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private boolean isPassed(int i) {
        return items[i].sellIn < 1;
    }

    private boolean isQualityBelow50(int i) {
        return items[i].quality < 50;
    }

    private boolean isKryptonite(int i) {
        return items[i].name.equals("Kryptonite");
    }

    private boolean isPassVipConcert(int i) {
        return items[i].name.equals("Pass VIP Concert");
    }

    private boolean isComte(int i) {
        return items[i].name.equals("Comté");
    }

    private void qualityPlusOne(Item item) {
        item.quality = item.quality + 1;
    }

    private void qualityPlus2(Item item) {
        item.quality = item.quality + 2;
    }

    private void qualityPlus3(Item item) {
        item.quality = item.quality + 3;
    }

    private void qualityMinusOne(Item item) {
        item.quality = item.quality - 1;
    }

    private void qualityMinusTwo(Item item) {
        item.quality = item.quality - 2;
    }

    private boolean isVipPassQualityToBeIncreasedBy2(int i) {
        return items[i].sellIn < 11 && items[i].sellIn > 5;
    }

    private boolean isVipPassQualityToBeIncreasedBy3(int i) {
        return items[i].sellIn < 6 && items[i].sellIn > 0;
    }

    private boolean isStandardItem(int i) {
        return !isComte(i) && !isPassVipConcert(i) && !isKryptonite(i);
    }

}
