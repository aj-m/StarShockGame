/*
 * Copyright (C) 2015 Andrew
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package starshockgame;
/**
 *
 * @author Andrew
 */
public class Ship {
    //private boolean allowOverheal;
    private int aggressionScale;
    private int currentHP;
    private int maxHP;
    private int kills;
    private int shipLevel;
    private Rank shipRank;
    private Ship currentTarget;
    
    public Ship(){
        this.aggressionScale = 1;
        this.maxHP = 1;
        this.currentHP = 1;
        this.shipLevel = 0;
        this.shipRank = Rank.BASIC;
        this.kills = 0;
    }
    
    public int getHP(){
        return this.currentHP;
    }
    public int getMaxHP(){
        return this.maxHP;
    }
    public int kills(){
        return this.kills;
    }
    public void damage(int dmg){
        this.currentHP -= dmg;
    }
    public void heal(int amt){
        if((this.currentHP + amt) < this.maxHP)
            this.currentHP += amt;
        else this.currentHP = this.maxHP;
    }
    public Ship getTarget(){
        return this.currentTarget;
    }
    public boolean promote(){
        switch(this.shipRank){
            case TRASH:
                this.shipRank = Rank.BASIC;
                break;
            case BASIC:
                this.shipRank = Rank.MEDIUM;
                break;
            case MEDIUM:
                this.shipRank = Rank.ELITE;
                break;
            case ELITE:
                this.shipRank = Rank.MINIBOSS;
                break;
            case MINIBOSS:
                this.shipRank = Rank.BOSS;
                break;
            case BOSS:
                this.shipRank = Rank.RARE_BOSS;
                break;
            case RARE_BOSS:
                this.shipRank = Rank.HYPER_BOSS;
                break;
            case HYPER_BOSS:
                this.shipRank = Rank.SECRET;
                //oh crap!
                break;
            default:
                return false;
        }
        return true;
    }
    public boolean demote(){
        switch(this.shipRank){
            case MEDIUM:
                this.shipRank = Rank.BASIC;
                break;
            case ELITE:
                this.shipRank = Rank.MEDIUM;
                break;
            case MINIBOSS:
                this.shipRank = Rank.ELITE;
                break;
            case BOSS:
                this.shipRank = Rank.MINIBOSS;
                break;
            case RARE_BOSS:
                this.shipRank = Rank.BOSS;
                break;
            case HYPER_BOSS:
                this.shipRank = Rank.RARE_BOSS;
                break;
            case SECRET:
                this.shipRank = Rank.HYPER_BOSS;
                break;            
            default:
                //Trash and Basic can't be demoted
                return false;
        }
        return true;
    }
    
}
