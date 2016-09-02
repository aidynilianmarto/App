package com.example.pc.olx.Offer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Kali on 2.9.2016 г..
 */
public class CategoryManager {


    private static ArrayList<Category> categories;

    private static CategoryManager ourInstance = new CategoryManager();

    public static CategoryManager getInstance() {
        return ourInstance;
    }

    private CategoryManager() {

        categories = new ArrayList<>();

        //Real estate
        Category realEstate = new Category ("Real estate");
        Category reSales = new Category ("Sales");
        Category reRent = new Category ("Rent");
        Category reRoomagetes = new Category ("Roommates");
        Category reOverseas = new Category ("Overseas properties");
        Category reNights = new Category ("Nights");

        realEstate.addCategory(reSales);
        realEstate.addCategory(reRent);
        realEstate.addCategory(reRoomagetes);
        realEstate.addCategory(reOverseas);
        realEstate.addCategory(reNights);
        categories.add(realEstate);

        //Cars and parts
        Category carsAndParts = new Category ("Cars and parts");
        Category cpCars = new Category ("Cars");
        Category cpBikesAndATB = new Category ("Bikes and ATB");
        Category cpParts = new Category ("Parts");
        Category cpAccessories = new Category ("Car accessories");
        Category cpTyresAndRims = new Category ("Tyres and rims");
        Category cpBusAndTruck = new Category ("Bus and truck");
        Category cpTrailers = new Category ("Trailers");
        Category cpAgroAndBuilding = new Category ("Agro and building");
        Category cpBoatsAndCaravans = new Category ("Boats and caravans");
        Category cpService = new Category ("Service");

        carsAndParts.addCategory(cpCars);
        carsAndParts.addCategory(cpBikesAndATB);
        carsAndParts.addCategory(cpParts);
        carsAndParts.addCategory(cpAccessories);
        carsAndParts.addCategory(cpTyresAndRims);
        carsAndParts.addCategory(cpBusAndTruck);
        carsAndParts.addCategory(cpTrailers);
        carsAndParts.addCategory(cpAgroAndBuilding);
        carsAndParts.addCategory(cpBoatsAndCaravans);
        carsAndParts.addCategory(cpService);
        categories.add(carsAndParts);

        //Electronics
        Category electronics = new Category ("Electronics");
        Category eComputers = new Category ("Computers");
        Category eComputerParts = new Category ("Computer parts and accessories");
        Category eTabletsAndReaders = new Category ("Tablets and readers");
        Category eSmartphones = new Category ("Smartphones");
        Category eAccessoriesAndPartsPhones = new Category ("Accessories and parts for phones");
        Category eTV = new Category ("TV");
        Category eAudio = new Category ("Audio");
        Category eAppliences = new Category ("Appliances");
        Category eAirConditioners = new Category ("Air conditioners");
        Category ePhotoAndVideo = new Category ("Photo and video");
        Category eNavigation = new Category ("Navigation");
        Category eOther = new Category ("Other electronics");

        electronics.addCategory(eComputers);
        electronics.addCategory(eComputerParts);
        electronics.addCategory(eTabletsAndReaders);
        electronics.addCategory(eSmartphones);
        electronics.addCategory(eAccessoriesAndPartsPhones);
        electronics.addCategory(eTV);
        electronics.addCategory(eAudio);
        electronics.addCategory(eAppliences);
        electronics.addCategory(eAirConditioners);
        electronics.addCategory(ePhotoAndVideo);
        electronics.addCategory(eNavigation);
        electronics.addCategory(eOther);
        categories.add(electronics);

        //Sport and hobby
        Category sportAndHobby = new Category ("Sport, hobby and books");
        Category spSport = new Category ("Sport");
        Category spTourismFishingCamping = new Category ("Fishing, camping and tourism");
        Category spBooks = new Category ("Books");
        Category spMusic = new Category ("Music");
        Category spMovies = new Category ("Movies");
        Category spAntiquesCollections = new Category ("Antiques and collections");
        Category spMusicalInstruments = new Category ("Musical instruments");
        Category spESmokes = new Category ("Electronical smokes and hookah");
        Category spTicketsEvents = new Category ("Tickets and events");
        Category spGames = new Category ("Games");

        sportAndHobby.addCategory(spSport);
        sportAndHobby.addCategory(spTourismFishingCamping);
        sportAndHobby.addCategory(spBooks);
        sportAndHobby.addCategory(spMusic);
        sportAndHobby.addCategory(spMovies);
        sportAndHobby.addCategory(spAntiquesCollections);
        sportAndHobby.addCategory(spMusicalInstruments);
        sportAndHobby.addCategory(spESmokes);
        sportAndHobby.addCategory(spTicketsEvents);
        sportAndHobby.addCategory(spGames);
        categories.add(sportAndHobby);


        //Animals
        Category animals = new Category ("Animals");
        Category aDogs = new Category ("Dogs");
        Category aCats = new Category ("Cats");
        Category aFish = new Category ("Fish");
        Category aBirds = new Category ("Birds");
        Category aFarmAnimals = new Category ("Farm animals");
        Category aOtherPets = new Category ("Other pets");
        Category aLostFound = new Category ("Other animals");
        Category aAccessories = new Category ("Pet accessories");
        Category aPartner = new Category ("Searching for parner");

        animals.addCategory(aDogs);
        animals.addCategory(aCats);
        animals.addCategory(aFish);
        animals.addCategory(aBirds);
        animals.addCategory(aFarmAnimals);
        animals.addCategory(aOtherPets);
        animals.addCategory(aLostFound);
        animals.addCategory(aAccessories);
        animals.addCategory(aPartner);
        categories.add(animals);

        //Home and garden
        Category homeAndGarden = new Category ("Home and garden");
        Category hgFurniture = new Category ("Furniture");
        Category hgDIY = new Category ("Do it yourself!");
        Category hgArtsDeco = new Category ("Arts and decorations");
        Category hgHome = new Category ("Home");
        Category hgCurtainsCarpets = new Category ("Curtains and carpets");
        Category hgLightning = new Category ("Lightning");
        Category hgSleewearFabric = new Category ("Sleepwear and fabric");
        Category hgGarden = new Category ("Garden");
        Category hgClean = new Category ("Everything for cleaning");
        Category hgCustomFurniture = new Category ("Custom furniture");
        Category hgFoods = new Category ("Foods, addons and drinks");
        Category hgWheelChairs = new Category ("Wheel chairs and other");
        Category hgOther = new Category ("Home and garden other");

        homeAndGarden.addCategory(hgFurniture);
        homeAndGarden.addCategory(hgDIY);
        homeAndGarden.addCategory(hgArtsDeco);
        homeAndGarden.addCategory(hgHome);
        homeAndGarden.addCategory(hgCurtainsCarpets);
        homeAndGarden.addCategory(hgLightning);
        homeAndGarden.addCategory(hgSleewearFabric);
        homeAndGarden.addCategory(hgGarden);
        homeAndGarden.addCategory(hgClean);
        homeAndGarden.addCategory(hgCustomFurniture);
        homeAndGarden.addCategory(hgFoods);
        homeAndGarden.addCategory(hgWheelChairs);
        homeAndGarden.addCategory(hgOther);
        categories.add(homeAndGarden);

        //Fashion
        Category fashion = new Category ("Fashion");
        Category fClothes = new Category ("Clothes");
        Category fShoes = new Category ("Shoes");
        Category fAccessories = new Category ("Fashion accessories");
        Category fCosmetics = new Category ("Perfumes and cosmetics");
        Category fJewelery = new Category ("Jewelery");
        Category fWatches = new Category ("Watches");

        fashion.addCategory(fClothes);
        fashion.addCategory(fShoes);
        fashion.addCategory(fAccessories);
        fashion.addCategory(fCosmetics);
        fashion.addCategory(fJewelery);
        fashion.addCategory(fWatches);
        categories.add(fashion);

        //Baby and childern
        Category babyAndChild = new Category ("Baby and children");
        Category bcClothes = new Category ("Baby and children clothes");
        Category bcShoes = new Category ("Baby and children shoes");
        Category bcStrolls = new Category ("Baby and child strolls");
        Category bcToys = new Category ("Toys");
        Category bcFurniture = new Category ("Furniture for child");
        Category bcAccessories = new Category ("Baby and children accessories");
        Category bcGoodsForTwins = new Category ("Goods for twins");
        Category bcOther = new Category ("Baby and children other");

        babyAndChild.addCategory(bcClothes);
        babyAndChild.addCategory(bcShoes);
        babyAndChild.addCategory(bcStrolls);
        babyAndChild.addCategory(bcToys);
        babyAndChild.addCategory(bcFurniture);
        babyAndChild.addCategory(bcAccessories);
        babyAndChild.addCategory(bcGoodsForTwins);
        babyAndChild.addCategory(bcOther);
        categories.add(babyAndChild);
    }

    public static Collection getCategories() {
        return Collections.unmodifiableList(categories);
    }

    public static ArrayList<String> toArrList(){
        ArrayList<String> str = new ArrayList<>();
        for(Category c : categories){
            str.add(c.toString());
        }

        return str;
    }
}
