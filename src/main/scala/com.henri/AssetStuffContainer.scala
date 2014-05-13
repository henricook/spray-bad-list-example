package com.henri

import spray.json._

object AssetStuffContainer {

  object AssetJsonProtocol extends DefaultJsonProtocol {
    implicit val ingestMetadataAssetProtocol = jsonFormat6(MyAsset.apply)
    implicit val ingestMetadataAssetListProtocol = jsonFormat1(AssetListObj.apply)
  }

  import AssetJsonProtocol._

  /**
   * A list of assets being ingested
   * @param asset
   */
  case class AssetList(
      asset: List[MyAsset]) {

    def json = this.toJson.compactPrint
  }

  object AssetListObj {
    def apply(jsonData: String): AssetList = jsonData.parseJson.convertTo[AssetList]
  }

  /**
   * Represents an asset being ingested
   *
   * Arguments that are used within automation are compulsory, unused ones are optional
   *
   * @param id
   * @param ingestReservationId
   * @param `type`
   * @param width
   * @param height
   */
  case class MyAsset(
          id: String,
          ingestReservationId: String,
          `type`: String, // Mime Type
          width: String,
          height: String,
          storageReservationId: String) {
    def json = this.toJson.compactPrint
  }

  object MyAsset {
    def apply(jsonData: String): MyAsset = jsonData.parseJson.convertTo[MyAsset]
  }


}
