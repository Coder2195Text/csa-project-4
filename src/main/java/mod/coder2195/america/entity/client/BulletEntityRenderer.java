package mod.coder2195.america.entity.client;

import mod.coder2195.america.AmericaMod;
import mod.coder2195.america.entity.custom.BulletEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

public class BulletEntityRenderer extends ProjectileEntityRenderer<BulletEntity> {
   public static final Identifier TEXTURE = new Identifier(AmericaMod.MOD_ID, "textures/entity/projectiles/bullet.png");

   public BulletEntityRenderer(EntityRendererFactory.Context context) {
      super(context);
   }

   public Identifier getTexture(BulletEntity arrowEntity) {
      return TEXTURE;
   }
}
