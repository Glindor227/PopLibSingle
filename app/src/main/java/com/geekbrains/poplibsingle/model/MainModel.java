package com.geekbrains.poplibsingle.model;

/*
class MainModel<Tin,Tout> {
    private Object obj = null;

    public void setObj(Tin obj) {
        this.obj = obj;
    }

    public Single<Tout> modelRXGo(){
        return Single.create((SingleOnSubscribe<Tout>) emitter -> {
            Gson gson = new GsonBuilder().create();
            GsonDate gsonDate = gson.fromJson((String) obj,GsonDate.class);
            emitter.onSuccess((Tout)gsonDate);
        }).subscribeOn(Schedulers.io());
    }

}

 */