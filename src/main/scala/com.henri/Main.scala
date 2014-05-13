package com.henri

import akka.actor.ActorSystem
import spray.json._
import com.henri.AssetStuffContainer._
import AssetJsonProtocol._

object Main extends App {

  println("Instantiating Asset")

  val testAsset = MyAsset(
    id = "hi",
    ingestReservationId = "hi2",
    width = "1920",
    height = "1080",
    storageReservationId = "hi3",
    `type` = "hi4"
  )

  println("Instantiated Asset")
  println("Asset = " + testAsset.json)

  println("Instantiating List")

  val testList = AssetList(
    List(
      MyAsset(
        id = "hi",
        ingestReservationId = "hi2",
        width = "1920a",
        height = "1080a",
        storageReservationId = "hi3",
        `type` = "hi4"
      ),
      MyAsset(
        id = "hi5",
        ingestReservationId = "hi6",
        width = "1920a",
        height = "1080a",
        storageReservationId = "hi7",
        `type` = "hi8"
      )
    )
  )

  println("Instantiated List")
  println("List JSON OUT = " + testList.json)

  val assetTestString = """{"asset":[{"id": "hi", "ingestReservationId": "hi", "width": "1920", "height": "1080", "storageReservationId": "hi3", "type": "hi4"}]}"""

  val assetConvert = assetTestString.parseJson.convertTo[AssetList]
}

