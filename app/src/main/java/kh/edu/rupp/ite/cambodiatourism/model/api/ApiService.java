package kh.edu.rupp.ite.cambodiatourism.model.api;

import java.util.List;

import kh.edu.rupp.ite.cambodiatourism.Data.CampsData;
import kh.edu.rupp.ite.cambodiatourism.model.Domain.CategoryDomain;
import kh.edu.rupp.ite.cambodiatourism.model.Domain.DetailDomain;
import kh.edu.rupp.ite.cambodiatourism.model.Domain.ExploreDomain;
import kh.edu.rupp.ite.cambodiatourism.model.Domain.MoreDomain;
import kh.edu.rupp.ite.cambodiatourism.model.Domain.PopularDomain;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {


    @GET("")
    Call<List<PopularDomain>> loadPopularList();

    @GET("")
    Call<List<MoreDomain>> loadMoreList();

    @GET("")
    Call<List<ExploreDomain>> loadExploreList();

    @GET("")
    Call<List<DetailDomain>> loadDetailList();

    @GET("")
    Call<List<CategoryDomain>> loadCategoryList();

    @GET("chhit.json")
    Call<List<CampsData>> getCamps();
}
