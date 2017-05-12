package com.yukihirai0505.macros

/**
  * Created by Yuky on 2017/05/12.
  */
import language.experimental.macros
import scala.reflect.macros.whitebox.Context

object PrintMacro {
  def p(msg: String): Unit = macro impl

  def impl(c: Context)(msg: c.Expr[String]) = {
    import c.universe._
    q"""
        println(${msg})
      """
  }
}